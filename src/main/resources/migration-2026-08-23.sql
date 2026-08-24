create table times (
    id bigint not null,
    nome_time varchar(100) not null,
    cidade varchar(80) not null,
    estado varchar(2) not null,
    ano_fundacao integer not null,
    estadio varchar(100),
    primary key (id)
) engine = InnoDB;

create table jogadores (
    id bigint not null,
    nome_jogador varchar(100) not null,
    posicao varchar(50) not null,
    numero_camisa integer not null,
    nacionalidade varchar(50) not null,
    apelido varchar(50),
    primary key (id)
) engine = InnoDB;