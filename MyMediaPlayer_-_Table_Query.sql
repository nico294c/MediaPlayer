-- COMMENT: There are no generated relations from the query

-- Generating the database

CREATE DATABASE MyMediaPlayer;

GO

-- Generating the tables with fields. Includes the PK and Identity Specifications

USE MyMediaPlayer;

CREATE TABLE tblSong            (fldSongID      INTEGER  IDENTITY(1,1) PRIMARY KEY  NOT NULL, 
                                 fldName        NCHAR(100) NULL,
								 fldLocation    NCHAR(100) NULL
								 );



CREATE TABLE tblPlaylist        (fldPlaylistID  INTEGER  IDENTITY(1,1) PRIMARY KEY  NOT NULL, 
                                 fldName        NCHAR(100) NULL
								 );


CREATE TABLE tblPlaylistContent (fldContentID  INTEGER   IDENTITY(1,1) PRIMARY KEY   NOT NULL,
								 fldSongID     INTEGER      NULL,
								 fldPlaylistID INTEGER      NULL
								 );


-- Hardcoding values into the tables

INSERT tblSong (fldName, fldLocation) 
	VALUES ('MC Virgins (ft Wonder) - Anime Thighs', NULL)

INSERT tblSong (fldName, fldLocation)
	VALUES ('Initial D - Running in the 90s', NULL)
	
INSERT tblSong (fldName, fldLocation) 
	VALUES ('Rasputin - Love the way you move', NULL)

INSERT tblSong (fldName, fldLocation)
	VALUES ('Boris (ft DJ Blyatman) - Slav King', NULL)

INSERT tblSong (fldName, fldLocation) 
	VALUES ('The Weekend - Blinding Lights', NULL)


GO