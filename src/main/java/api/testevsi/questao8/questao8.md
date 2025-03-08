## 1. Caso de Uso: Gerenciamento de plantas

### **Nome**
Gerenciamento de Plantas no Sistema XYZ

### **Descrição**
O sistema XYZ deve permitir que usuários criem, atualizem, excluam e pesquisem plantas, garantindo que apenas administradores possam excluir registros e que não tenha duplicação de códigos.

### **Ator(es)**
- **Usuário**: Criar, atualizar e pesquisar plantas.
- **Administrador**: Criar, atualizar, pesquisar e excluir plantas.

### **Fluxo principal**

1. O usuário acessa o sistema XYZ e navega até a funcionalidade de gerenciamento de plantas.
2. O usuário pode visualizar a lista de plantas cadastradas e utilizar filtros para busca.
3. O usuário pode adicionar uma nova planta, informando um código numérico únic* e, opcionalmente, uma descrição de até 10 caracteres.
4. O sistema valida se o código já existe. Se existir, exibe um erro.
5. O usuário pode editar uma planta existente, modificando seu código (se permitido) e/ou sua descrição.
6. O usuário pode excluir uma planta, mas apenas se for administrador.
7. O sistema confirma a exclusão e remove a planta da base de dados.
8. O sistema registra todas as alterações feitas, garantindo auditoria das ações.

## 2. Regras de negócio

### **Regras de negócio**
- O código da planta deve ser único e apenas numérico.
- O campo descrição é opcional e pode ter até 10 caracteres alfanuméricos.
- Apenas administradores podem excluir registros de plantas.
- O sistema deve evitar codigos duplicados no momento da criação e edição.

## 3. Validações e medidas de segurança

### **Validações**
- O codigo deve ser numérico e único. Tentativas de cadastrar um código duplicado devem ser bloqueadas.
- A descrição deve respeitar o limite de 10 caracteres e não pode conter caracteres especiais inválidos.
- O sistema deve verificar a permissão do usuário antes de permitir exclusões.

### **Medidas de segurança**
- Autenticação e Autorização: Garantir que apenas usuários autenticados possam acessar a funcionalidade.
- Controle de Permissões: Apenas administradores podem excluir registros.
- Validação de Entrada: Prevenir injeção de SQL e entrada de dados inválidos.


## 4. Testes e casos extremos

### **Testes funcionais**
 Criar uma planta com código único e descrição válida.  
 Criar uma planta sem descrição (opcional).  
 Tentar criar uma planta com código já existente (deve falhar).  
 Pesquisar plantas usando filtros como código e descrição.  
 Editar uma planta existente alterando apenas a descrição.  
 Editar uma planta existente tentando alterar o código para um que já existe (deve falhar).  
 Excluir uma planta como administrador (deve funcionar).  
 Tentar excluir uma planta como usuário comum (deve falhar).

### **Testes de segurança**
 Tentar criar, editar ou excluir plantas sem estar autenticado (deve falhar).  
 Tentar excluir uma planta como usuário comum (deve falhar).  
 Testar injeção de SQL ou XSS ao inserir dados na descrição (deve ser bloqueado).  
 Verificar se o sistema registra logs e auditoria corretamente para todas as ações.

### **Testes de desempenho**
 Criar 10.000 registros de plantas e testar o tempo de resposta do sistema ao realizar buscas.  
 Simular múltiplos usuários simultâneos criando e editando plantas para testar concorrência no banco de dados.
