# Sistema de Cadastro de Pessoas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![WildFly](https://img.shields.io/badge/WildFly-000?style=for-the-badge&logo=wildfly&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JSF](https://img.shields.io/badge/JSF-888?style=for-the-badge&logo=java&logoColor=white)
![PrimeFaces](https://img.shields.io/badge/PrimeFaces-000?style=for-the-badge&logo=primefaces&logoColor=white)

---

## **Sobre o Projeto**
O **Sistema de Cadastro de Pessoas** é uma aplicação para gestão de informações pessoais. Ele permite:
- Cadastrar novas pessoas.
- Gerenciar documentos, endereços e contatos associados.
- Pesquisar, editar e remover registros.

---

## **Funcionalidades**
### **Tela de Pesquisa**
- Busca pessoas pelo nome.
- Exibe resultados com opções de edição e exclusão.

### **Tela de Cadastro**
- Permite cadastrar uma nova pessoa.
- Formulários para adicionar:
  - Documentos.
  - Endereços.
  - Contatos.

---

## **Configuração do Ambiente**
### **Banco de Dados**
- **Banco Utilizado**: PostgreSQL.
- **Configurações de Conexão**:
  - URL: `jdbc:postgresql://localhost:5432/personControl`
  - Usuário: `postgres`
  - Senha: `root`
- **Observação**: A tabela é gerenciada automaticamente pelo Hibernate.

### **Servidor de Aplicação**
- **Servidor**: WildFly 20.0.1.
- **Data Source Configurado**: `jdbc/personControlDS`.

### **IDE**
- Desenvolvido utilizando **NetBeans**.

### **Dependências**
- O arquivo `persistence.xml` gerencia as configurações do banco de dados.
- Entidades Java são mapeadas com JPA.

---

## **Como Executar**
1. **Configurar o Banco de Dados**:
   - Crie um banco chamado `personControl` no PostgreSQL.
   - Configure o usuário e a senha como descrito acima.
   - Certifique-se de que o WildFly pode se conectar ao banco via `jdbc/personControlDS`.

2. **Configurar o Driver JDBC**:
   - Adicione o driver PostgreSQL ao WildFly:
     ```
     <wildfly-home>/modules/system/layers/base/org/postgresql/main
     ```
   - Crie o arquivo `module.xml` conforme descrito no código do projeto.

3. **Fazer o Deploy**:
   - Compile o projeto com Maven:
     ```
     mvn clean install
     ```
   - Copie o arquivo `personControl.war` gerado para a pasta de deploy do WildFly:
     ```
     <wildfly-home>/standalone/deployments
     ```

4. **Acessar a Aplicação**:
   - Inicie o WildFly e acesse:
     ```
     http://localhost:8080/personControl
     ```

---

## **Autor**
**Felipe Soares**  
[GitHub: felipeassoares](https://github.com/felipeassoares)

