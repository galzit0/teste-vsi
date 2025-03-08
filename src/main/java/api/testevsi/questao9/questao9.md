# Questão 9

## 1. Tipos de testes

### **Testes unitários**
- Verificam a lógica interna de cada função isoladamente.
- Exempo: Garantir que emails duplicados não sejam permitidos.

### **Testes de integração**
- Validam a interação entre diferentes camadas do sistema (exemplo: backend e banco de dados).
- Exemplo: Testar se o banco de dados rejeita emails duplicados corretamente.

### **Testes de ponta a ponta (E2E)**
- Simulam um usuário real interagindo com o sistema, testando interface, API e banco de ponta a ponta.
- Exemplo: Criar um usuário via UI, editá-lo e excluí-lo como administrador.


## 2. Cenários de teste

### **Cenários de teste funcionais**
- Criar um usuário com dados válidos.
- Criar um usuário sem preencher campo obrigatório nome ou email e deve falhar.
- Criar um usuário com email já existente e deve falhar.
- Atualizar o nome e o telefone de um usuário existente.
- Atualizar um usuário tentando alterar o email para um já existente e deve falhar.
- Excluir um usuário como administrador e deve funcionar.
- Excluir um usuário como usuário comum e deve falhar.

### 🔥 **Casos extremos e tratamento**
- **Criar um usuário com um email inválido** (`"usuario@@email"`) O sistema deve validar e rejeitar.
- **Criar um usuário com um nome extremamente longo** (`"A" * 256`) Deve ser limitado pelo backend.
- **Criar 100.000 usuários simultaneamente** Teste de carga para avaliar desempenho.
- **Exclusão em massa de usuários** Deve ser permitido apenas para administradores.

## 3. Exemplo de caso de teste em código

teste unitário com JUnit + Spring Boot para validar que o email é unico:

```java

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void naoPermitirCriarUsuarioEmailExistente() {
        Usuario usuario1 = new Usuario("gabriel", "gabriel@.com", "Endereço 1", "1111111");
        usuarioService.criarUsuario(usuario1);

        Usuario usuario2 = new Usuario("renata", "gabriel@.com", "Endereço 2", "2222222");

        assertThrows(EmailEmUsoException.class, () -> {
            usuarioService.criarUsuario(usuario2);
        });
    }
}
