use bookAuthorDb;

CREATE TABLE IF NOT EXISTS Book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier
    title VARCHAR(255) NOT NULL UNIQUE, -- Unique username
    gender VARCHAR(255) NOT NULL, -- Player's email
    author_id BIGINT NOT NULL 
    FOREIGN KEY (author_id) REFERENCES Author(id) 
);

-- Create the Friend table
CREATE TABLE IF NOT EXISTS Author (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier
    lastName VARCHAR(255) NOT NULL UNIQUE, -- Unique name
    firstName VARCHAR(255) NOT NULL UNIQUE, -- Unique name
);