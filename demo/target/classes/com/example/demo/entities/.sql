CREATE TABLE user (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Assuming you want a 64-bit integer for ID
  username VARCHAR(255) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE comment (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Assuming you want a 64-bit integer for ID
  content TEXT,
  -- Add other fields for comments as needed
  user_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE evaluation (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Assuming you want a 64-bit integer for ID
  content TEXT,
  
  user_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(id)
);