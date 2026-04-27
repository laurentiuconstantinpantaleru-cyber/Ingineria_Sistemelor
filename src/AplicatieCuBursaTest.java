
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.List;

public class AplicatieCuBursaTest {

    @org.testng.annotations.Test
    public void testSorteaza() {
        AplicatieCuBursa app = new AplicatieCuBursa();
        List<StudentBursier> lista = app.genereaza();
        List<StudentBursier> sortata = app.sorteaza(lista);

        // Verificăm dacă lista nu este nulă și are dimensiunea corectă
        assertNotNull(sortata);
        assertEquals(5, sortata.size());

        // Primul ar trebui să fie Mihalcea (ISM141/1 vine înaintea ISM141/2 și TI131/1)
        assertEquals("Mihalcea", sortata.get(0).getNume());
        assertEquals("ISM141/1", sortata.get(0).getFormatieDeStudiu());

        // Verificăm sortarea pe același nume (Popescu Bianca) dar burse diferite
        // Cea cu bursa 100.00 ar trebui să fie înaintea celei cu 780.80 (ordine crescătoare)
        int indexBianca100 = -1;
        int indexBianca780 = -1;

        for(int i=0; i<sortata.size(); i++) {
            if(sortata.get(i).getNume().equals("Popescu") && sortata.get(i).getCuantumBursa() == 100.00) indexBianca100 = i;
            if(sortata.get(i).getNume().equals("Popescu") && sortata.get(i).getCuantumBursa() == 780.80) indexBianca780 = i;
        }

        assertTrue(indexBianca100 < indexBianca780, "Studentul cu bursa mai mica trebuie sa fie inainte la aceleasi criterii de nume.");
    }
}