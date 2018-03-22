# xy-inc
Desafio Back-end PL

Os serviços foram desenvolvidos com Java utilizando JPA/Hibernate, Spring boot e o banco de dados Postgresql, portanto para rodar a aplicação é necessário ter um banco de dados Postgresql, criar uma base de dados com o nome "xyinc" com owner postgres e senha "admin" e rodar o seguinte script para criar a tabela que será usada: 

CREATE TABLE public.tb_ponto_interesse
(
    cod_ponto_interesse integer NOT NULL,
    coordenada_x integer NOT NULL,
    coordenada_y integer NOT NULL,
    nom_ponto_interesse character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tb_ponto_interesse_pkey PRIMARY KEY (cod_ponto_interesse),
    CONSTRAINT unq_nom_ponto_interesse UNIQUE (nom_ponto_interesse)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tb_ponto_interesse
    OWNER to postgres;
    
Feito isso, é necessário realizar o checkout do projeto e inicializar a aplicação com a classe XyIncApplication que possui o método main.

Testando os serviços:

Serviço 1: Serviço para cadastrar pontos de interesse com 3 atributos:
Em qualquer client, com um método post utilize:
Url: http://localhost:9999/api/pontointeresse/create
e enviar um JSON de request.
JSON exemplo para criação de um pontoInteresse:
{
	"nome":"Lanchonete",
	"coordenadaX":"27",
	"coordenadaY":12
}

Serviço 2: Serviço para listar todos os POIs cadastrados.
Em qualquer client, com um método get utilize:
http://localhost:9999/api/pontointeresse/readAll

Serviço 3: Serviço para listar POIs por proximidade.
Em qualquer client, com um método post utilize:
Url: http://localhost:9999/api/pontointeresse/readByDistancia
e enviar um JSON de request.
JSON exemplo de request:
{
	"distanciaX":"20",
	"distanciaY":"10",
	"distanciaMax":10
}

Observações:
- Eu utilizei o Postman para os testes;
- Dividi o código em camadas para separar as funções de cada camada (Business,DAO,WEB e Entity);
- Utilizei classes e métodos genéricos para maior extensibilidade e manutenbilidade por mais que só tenha uma entidade, atribui métodos especificos a ela somente quando não foi possível generalizare nas regras de negócio específicas da entidade;
- Realizei testes unitários com JUnit e Mockito;
- No serviço 3, no exemplo que foi me dado ficou faltando o retorno da churrascaria, considerei a distância máxima tanto para cima quanto para baixo portanto no meu serviço a churrascaria também é retornada utilizando os mesmos exemplos.
