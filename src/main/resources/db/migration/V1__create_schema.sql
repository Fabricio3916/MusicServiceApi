CREATE TABLE artist (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE album (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       artist_id INT REFERENCES artist(id)
);

CREATE TABLE music (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       duration_seconds INT NOT NULL,
                       album_id INT REFERENCES album(id),
                       genre VARCHAR(255)
);
