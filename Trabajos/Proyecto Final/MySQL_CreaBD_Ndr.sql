CREATE TABLE Sede (
	chr_sedecodigo       	CHAR(2) NOT NULL,
	vch_sedenombre			VARCHAR(40)	NOT NULL,
	vch_sedeciudad			VARCHAR(40) NOT NULL,
	CONSTRAINT XPK_SEDE 
		PRIMARY KEY (chr_sedecodigo)				
)ENGINE = INNODB ;

CREATE TABLE Escuela (
	vch_escucodigo       	VARCHAR(5) NOT NULL,
	vch_escunombre			VARCHAR(40) NOT NULL,
	CONSTRAINT XPK_ESCUELA
		PRIMARY KEY (vch_escucodigo)	
) ENGINE = INNODB ;

CREATE TABLE Aula (
	chr_aulacodigo       	CHAR(2) NOT NULL,
	vch_aulaturno			VARCHAR(40) NOT NULL,
	chr_sedecodigo			CHAR(2) NOT NULL,
	vch_aulaedad			VARCHAR(40) NOT NULL,	
	CONSTRAINT XPK_AULA 
		PRIMARY KEY (chr_aulacodigo),
	CONSTRAINT FK_AULA_SEDECODIGO
		FOREIGN KEY (chr_sedecodigo)
		REFERENCES Sede (chr_sedecodigo)
) ENGINE = INNODB ;

CREATE TABLE Maestro (
	chr_maesdni				CHAR(8) NOT NULL,
	vch_maespaterno			VARCHAR(40) NOT NULL,
	vch_maesmaterno			VARCHAR(40) NOT NULL,
	vch_maesnombre			VARCHAR(40) NOT NULL,
	vch_maesdistrito	   	VARCHAR(40) NOT NULL,
	vch_maestelefono		VARCHAR(40) NOT NULL,
	vch_maeseducacion		VARCHAR(40) NOT NULL,
	vch_maesusuario			VARCHAR(15) NOT NULL,
	vch_maesclave			VARCHAR(15) NOT NULL,
	vch_comentariocoord		VARCHAR(400) NOT NULL,
	vch_escucodigo       	VARCHAR(5) NOT NULL,
	CONSTRAINT XPK_MAESTRO
		PRIMARY KEY (chr_maesdni),
	CONSTRAINT FK_MAESTRO_ESCUCODIGO
		FOREIGN KEY (vch_escucodigo)
			REFERENCES Escuela (vch_escucodigo)
) ENGINE = INNODB;

CREATE TABLE Apoderado (
	chr_apodni				CHAR(8) NOT NULL,
	vch_apopaterno			VARCHAR(40) NOT NULL,
	vch_apomaterno			VARCHAR(40) NOT NULL,
	vch_aponombre			VARCHAR(40) NOT NULL,
	vch_apotelefono			VARCHAR(40) NOT NULL,
	vch_apodistrito			VARCHAR(40) NOT NULL,
	vch_frecasistencia		VARCHAR(40) NOT NULL,
	vch_escucodigo       	VARCHAR(5) NOT NULL,
	CONSTRAINT XPK_APODERADO 
		PRIMARY KEY (chr_apodni),
	CONSTRAINT FK_APODERADO_ESCUCODIGO
		FOREIGN KEY (vch_escucodigo)
			REFERENCES Escuela (vch_escucodigo)
) ENGINE = INNODB ;

CREATE TABLE Estudiante (
	chr_estudni				CHAR(8) NOT NULL,
	vch_estupaterno			VARCHAR(40) NOT NULL,
	vch_estumaterno			VARCHAR(40) NOT NULL,
	vch_estunombre			VARCHAR(40) NOT NULL,
	dtt_estunacimiento		DATE NOT NULL,
	vch_estudistrito		VARCHAR(40) NOT NULL,
	vch_comentariomaes		VARCHAR(400) NOT NULL,
	vch_comentarioapo		VARCHAR(400) NOT NULL,
	chr_encuentro			CHAR(2) NOT NULL,
	chr_apodni				CHAR(8) NOT NULL,	
	CONSTRAINT XPK_ESTUDIANTE
		PRIMARY KEY (chr_estudni),
	CONSTRAINT FK_ESTUDIANTE_APODNI
		FOREIGN KEY (chr_apodni)
			REFERENCES Apoderado (chr_apodni)
) ENGINE = INNODB ;

CREATE TABLE Curso (
	chr_cursocodigo			CHAR(2) NOT NULL,
	chr_aulacodigo       	CHAR(2) NOT NULL,
	chr_maes1dni			CHAR(8) NOT NULL,
	chr_maes2dni			CHAR(8),
	chr_maes3dni			CHAR(8),
	chr_maes4dni			CHAR(8),
	vch_cursoperiodo		VARCHAR(40) NOT NULL,
	CONSTRAINT XPK_CURSO
		PRIMARY KEY (chr_cursocodigo),
	CONSTRAINT fk_curso_aulacodigo
		FOREIGN KEY (chr_aulacodigo)
			REFERENCES Aula (chr_aulacodigo),
	CONSTRAINT fk_curso_maes1dni
		FOREIGN KEY (chr_maes1dni)
			REFERENCES Maestro (chr_maesdni),
	CONSTRAINT fk_curso_maes2dni
		FOREIGN KEY (chr_maes2dni)
			REFERENCES Maestro (chr_maesdni),	
	CONSTRAINT fk_curso_maes3dni
		FOREIGN KEY (chr_maes3dni)
			REFERENCES Maestro (chr_maesdni),	
	CONSTRAINT fk_curso_maes4dni
		FOREIGN KEY (chr_maes4dni)
			REFERENCES Maestro (chr_maesdni)			
) ENGINE = INNODB ;

CREATE TABLE Asistencia (
	chr_cursocodigo			CHAR(2) NOT NULL,
	chr_estudni				CHAR(8) NOT NULL,
	dtt_asisfecha			DATE NOT NULL,
	CONSTRAINT XPK_Asistencia 
		PRIMARY KEY (chr_cursocodigo, chr_estudni, dtt_asisfecha),
	CONSTRAINT fk_asis_cursocodigo
		FOREIGN KEY (chr_cursocodigo)
			REFERENCES Curso (chr_cursocodigo),
	CONSTRAINT fk_asis_estudni
		FOREIGN KEY (chr_estudni)
			REFERENCES Estudiante (chr_estudni)
) ENGINE = INNODB ;

CREATE TABLE Contador (
       vch_conttabla        VARCHAR(30) NOT NULL,
       int_contitem         INTEGER NOT NULL,
       int_contlongitud     INTEGER NOT NULL,
       CONSTRAINT XPKContador 
              PRIMARY KEY (vch_conttabla)
) ENGINE = INNODB ;