package flowerstore.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import flowerstore.flower.Flower;
import flowerstore.flower.FlowerColor;
import flowerstore.flower.FlowerType;
import flowerstore.repository.FlowerRepository;

import java.util.List;
import java.util.Arrays;

public class FlowerServiceTest {

    @Test
    public void testGetFlowers() {
        FlowerRepository repo = Mockito.mock(FlowerRepository.class);
        Flower f1 = new Flower(3.0, FlowerColor.RED, 2.0, FlowerType.CHAMOMILE);
        Flower f2 = new Flower(4.0, FlowerColor.BLUE, 3.0, FlowerType.TULIP);

        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(f1, f2));

        FlowerService service = new FlowerService(repo);
        List<Flower> flowers = service.getFlowers();

        Assertions.assertEquals(2, flowers.size());
        Assertions.assertEquals(f1.getPrice(), flowers.get(0).getPrice());
    }

    @Test
    public void testAddFlower() {
        FlowerRepository repo = Mockito.mock(FlowerRepository.class);
        Flower f = new Flower(5.0, FlowerColor.RED, 7.0, FlowerType.ROSE);

        Mockito.when(repo.save(f)).thenReturn(f);

        FlowerService service = new FlowerService(repo);
        Flower saved = service.addFlower(f);

        Assertions.assertSame(f, saved);
        Mockito.verify(repo).save(f);
    }
}
