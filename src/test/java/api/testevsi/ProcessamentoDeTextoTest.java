package api.testevsi;

import api.testevsi.questao1.ProcessamentoDeTexto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ProcessamentoDeTextoTest {
    @Test
    public void testGerarAnagrama() {
        List<String> result = ProcessamentoDeTexto.processarTexto("abc");
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertEquals(6, result.size());
    }

    @Test
    public void testUmaLetra() {
        List<String> result = ProcessamentoDeTexto.processarTexto("a");
        assertEquals(1, result.size());
        assertEquals("a", result.get(0));
    }

    @Test
    public void testVazio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ProcessamentoDeTexto.processarTexto("");
        });
        assertEquals("Não pode ser vazio.", exception.getMessage());
    }

}
