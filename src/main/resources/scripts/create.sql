CREATE TABLE IF NOT EXISTS race(
    pkRace IDENTITY PRIMARY KEY,
    raceName VARCHAR(25) UNIQUE,
);

CREATE TABLE IF NOT EXISTS character(
    pkCharacter IDENTITY PRIMARY KEY,
	characterName VARCHAR(25) UNIQUE,
	fkRace INT,
    carrier	BOOLEAN,   
    
    CONSTRAINT fk_race foreign key (fkRace) references race(p) ON DELETE CASCADE
);