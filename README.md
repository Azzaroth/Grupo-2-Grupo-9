# Grupo-2-Grupo-9
## 1. Instruções para configuração do projeto:

Configurar no pgAdminIII um nova conexão com as seguintes propriedades:

* Host: localhost
*Porta: 5432
* Base de dados: comperfectdb
* Usuário: postgres
* Senha: postgres

*Ou editar o arquivo hibernate.cfg.xml e criar uma conexão de sua preferência.

# 2. Instruções para execução do projeto:

O cadastro de produtos não faz parte do projeto pois não é realizado pelo usuário. Porém, é necessário que um cadastro seja realizado para que aconteça a criação automática da tabela PRODUTOS dentro do banco de dados.

* Utilizando o Netbeans execute primeiro o arquivo cadproduto.xhtml (com o código aberto no Netbeans pode ser executado com o atalho shift+f6)
* Realize um cadastro qualquer para teste
* Atualize a página, um cadastro será mostrado na parte inferior da página.

# 3. Instruções para popular o banco de dados com os produtos já cadastrados:

* Abrir o pgAdminIII e encontrar e selecionar a tabela PRODUTOS
* Com a tabela selecionada, clique em "Execute arbitrary SQL queries" que está no menu superior e uma janela será aberta
* Copie para a janela o código contido no arquivo "banco completo" que está anexado ao github. O código apagará o registro criado como teste e preenchará o banco com produtos reais

# 4. Instruções para a execução do projeto:

* Abra no Netbeans o arquivo Produtos.xhtml e com o código aberto execute com o atalho shift+f6
