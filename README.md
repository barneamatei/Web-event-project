# SpringBootRenderExample

https://inginerie-software-demo.up.railway.app/

### Remember, first create the database locally ticket_store, then run the app such that the tables are created (roles, users, users_roles)

### Then Execute the sql statements


INSERT INTO roles(id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'DEVELOPER');



INSERT INTO users(username, email_address, first_name, last_name, password)
VALUES ('Admin', 'admin@admin.com', 'Admin', 'Admin', '$2a$10$FVvZNPIIP3taMKdQqwwWsejbiH1DpT/0/PbBS933b73JewnHag6hK');

INSERT INTO users_roles(users_id, roles_id) VALUES (1, 1);


$2a$10$FVvZNPIIP3taMKdQqwwWsejbiH1DpT/0/PbBS933b73JewnHag6hK    is the BCrypt hash of password Admin!1234


### Deploy to RailWay: https://www.youtube.com/watch?v=F-Y67-DiM9c
