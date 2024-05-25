CREATE TABLE movies ( id SERIAL PRIMARY KEY, title VARCHAR(255) NOT NULL, description TEXT, release_date DATE, genre VARCHAR(50), country VARCHAR(50), rating DECIMAL(3,1), image_path VARCHAR(255), content_type VARCHAR(50), director VARCHAR(100), length INT, actors TEXT);

INSERT INTO movies (title,  description,  release_date,  genre,  country,  rating,  image_path,  content_type,  director,  length,  actors) 
 VALUES ('Poderoso Chefão',  'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',  "movie",  'Crime,ma',  'USA',  9.2,  'https://i.ebayimg.com/images/g/oFkAAOSwoWRjZOHS/s-l1600.webp',  "movie",  'Francis Ford Coppola',  175,  'Marlon Brando,Pacino,es Caan')

INSERT INTO movies (title,  description,  release_date,  genre,  country,  rating,  image_path,  content_type,  director,  length,  actors) 
 VALUES ('Avatar',  'A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.',  "movie",  'Action,enture,tasy',  'USA',  7.8,  'https://images-cdn.ubuy.ae/645259063814b57678147114-avatar-movie-poster-quality-silk-print.jpg',  "movie",  'James Cameron',  162,  'Sam Worthington, Saldana,ourney Weaver')

INSERT INTO movies (title,  description,  release_date,  genre,  country,  rating,  image_path,  content_type,  director,  length,  actors) 
 VALUES ('Pulp Fiction',  'The lives of two mob hitmen,oxer,angster and his wife, a pair of diner bandits intertwine in four tales of violence and redemption.',  NULL,  'Crime,ma',  'USA',  8.9,  'https://images-cdn.ubuy.co.in/653f9763c9fb060a774b8193-pulp-fiction-movie-poster-regular.jpg',  "movie",  'Quentin Tarantino',  154,  'John Travolta, Thurman,uel L. Jackson')

INSERT INTO movies (title,  description,  release_date,  genre,  country,  rating,  image_path,  content_type,  director,  length,  actors) 
 VALUES ('Suicide Squad',  'A secret government agency recruits some of the most dangerous incarcerated super-villains to form a defensive task force. Their first mission: save the world from the apocalypse.',  "movie",  'Action,enture,tasy',  'USA',  6.0,  'https://images-cdn.ubuy.co.in/633d25b853c5092f5f4bbb0c-movie-poster-suicide-squad-2-sided.jpg',  "movie",  'David Ayer',  123,  'Will Smith,ed Leto,got Robbie')

INSERT INTO movies (title,  description,  release_date,  genre,  country,  rating,  image_path,  content_type,  director,  length,  actors) 
 VALUES ('Top Gun',  'As students at the United States Navys elite fighter weapons school compete to be best in the class, daring young pilot learns a few things from a civilian instructor that are not taught in the classroom.',  "movie",  'Action,ma',  'USA',  6.9,  'https://m.media-amazon.com/images/I/71BokibfVUL._AC_SL1500_.jpg',  "movie",  'Tony Scott',  110,  'Tom Cruise, Robbins,ly McGillis')

INSERT INTO movies (title,  description,  release_date,  genre,  country,  rating,  image_path,  content_type,  director,  length,  actors) 
 VALUES ('Duna',  'In a future where humanity extracts a precious spice from a dangerous desert planet,e Leto Atreides accepts stewardship of the planet Arrakis. However,reacherous conspiracy threatens to destroy everything he holds dear.',  "movie",  'Sci-Fi',  'EUA',  8.1,  'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMB9-TdY3_zTfS5OtWaFOS9A5rcqZTDeX0jypSs9Vsyg&s',  "movie",  'Denis Villeneuve',  155,  'Timothée Chalamet,ecca Ferguson,ar Isaac')

