Sistema de Cadastro de Pessoas
Este projeto é um sistema de cadastro de pessoas desenvolvido com as seguintes tecnologias:

WildFly: Servidor de aplicação.
JSF (JavaServer Faces): Framework para criação de interfaces web.
PrimeFaces: Biblioteca de componentes para JSF.
Hibernate e JPA (Java Persistence API): Para persistência e gerenciamento de dados.
Funcionalidades
Tela de Pesquisa:

Permite pesquisar pessoas por nome.
Lista os resultados abaixo da pesquisa com opções para editar ou remover.
Tela de Cadastro:

Permite adicionar uma nova pessoa ao sistema.
Inclui formulários para cadastrar:
Lista de documentos.
Lista de endereços.
Lista de contatos.
Configuração do Ambiente
Banco de Dados:

Banco utilizado: PostgreSQL.
Configurações de conexão:
URL: jdbc:postgresql://localhost:5432/personControl
Usuário: postgres
Senha: root
A tabela é gerenciada automaticamente pelo Hibernate.
Servidor de Aplicação:

Utilizado WildFly 20.0.1.
Configuração do data source: jdbc/personControlDS.
IDE:

Projeto desenvolvido utilizando NetBeans.
Dependências e Arquivos Principais:

O arquivo persistence.xml gerencia a configuração do banco de dados.
As entidades são mapeadas em classes Java para persistência com JPA.
