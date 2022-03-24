CREATE TABLE Usuario(
    ID int not null primary key generated always 
        as identity (start with 1 increment by 1),
    username varchar(100) not null,
    senha varchar(20) not null,
    nome varchar(100)
);

CREATE TABLE Mensagem(
    ID int not null primary key generated always 
        as identity (start with 1 increment by 1),
    corpo VARCHAR(250) not null,
    id_remetente int not null,
    id_destinatario int not null,
    CONSTRAINT fk_Mensagem_Usuario_remetente FOREIGN KEY
    (id_remetente) REFERENCES Usuario(id),
    CONSTRAINT fk_Mensagem_Usuario_destinatario FOREIGN KEY
    (id_destinatario) REFERENCES Usuario(id)
);