CREATE TABLE MetaData (
    id SERIAL PRIMARY KEY,
    metadata TEXT
);

CREATE TABLE MetaDataValues (
    id SERIAL PRIMARY KEY,
    metaDataId INT,
    metaDataValues TEXT,
    FOREIGN KEY (metaDataId) REFERENCES MetaData(id)
);

CREATE TABLE File (
    id SERIAL PRIMARY KEY,
    fileName VARCHAR(255),
    fileInfo BYTEA NOT NULL,
    metaDataId INT,
    metaDataValueId INT,
    FOREIGN KEY (metaDataId) REFERENCES MetaData(id),
    FOREIGN KEY (metaDataValueId) REFERENCES MetaDataValues(id)
);
