-- COMMENT: There are no generated relations from the query
-- Generating the database

CREATE DATABASE MyMediaPlayer;

GO

-- Generating the tables with fields. Includes the PK and Identity Specifications

USE MyMediaPlayer;

CREATE TABLE tblSong            (fldSongID      INTEGER  IDENTITY(1,1) PRIMARY KEY  NOT NULL, 
                                 fldName        NCHAR(50)  NULL,
							     fldArtist      NCHAR(50)  NULL,
                                 fldLocation    NCHAR(100) NULL
								 );



CREATE TABLE tblPlaylist        (fldPlaylistID  INTEGER  IDENTITY(1,1) PRIMARY KEY  NOT NULL, 
                                 fldName        NCHAR(100) NULL
								 );


CREATE TABLE tblPlaylistContent (fldContentID  INTEGER   PRIMARY KEY   NOT NULL,
								 fldSongID     INTEGER      NULL,
								 fldPlaylistID INTEGER      NULL
								 );


-- Hardcoding values into the tables

INSERT tblSong (fldName, fldArtist, fldLocation) 
	VALUES ('Anime Thighs', 'MC Virgins (ft Wonder)', NULL)

INSERT tblSong (fldName, fldArtist, fldLocation)
	VALUES ('Running in the 90s', 'Initial D', NULL)
	
INSERT tblSong (fldName, fldArtist, fldLocation) 
	VALUES ('Love the way you move', 'Rasputin', NULL)

INSERT tblSong (fldName, fldArtist, fldLocation)
	VALUES ('Slav King', 'Boris (ft DJ Blyatman)', NULL)

INSERT tblSong (fldName, fldArtist, fldLocation) 
	VALUES ('Blinding Lights', 'The Weekend', NULL)


GO