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

