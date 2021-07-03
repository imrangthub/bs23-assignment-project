INSERT INTO roles_tbl (`id`, `description`, `is_deleted`, `name`) VALUES ('1', 'Role for User', '0', 'ROLE_USER');
INSERT INTO roles_tbl (`id`, `description`, `is_deleted`, `name`) VALUES ('2', 'Role for Admin', '0', 'ROLE_ADMIN');
INSERT INTO roles_tbl (`id`, `description`, `is_deleted`, `name`) VALUES ('3', 'Role for Super Admin', '0', 'SUPER_ADMIN');


INSERT INTO location_tbl (`id`, `is_active`, `title`) VALUES ('1', '1', 'Sylhet');
INSERT INTO location_tbl (`id`, `is_active`, `title`) VALUES ('2', '1', 'Bandarban');
INSERT INTO location_tbl (`id`, `is_active`, `title`) VALUES ('3', '1', 'Khulna');
INSERT INTO location_tbl (`id`, `is_active`, `title`) VALUES ('4', '0', 'Chattogram');


INSERT INTO users_tbl (`id`, `full_name`, `password`, `username`) VALUES ('1', 'MD Imran Hossain', '12345', 'imran');
INSERT INTO users_tbl (`id`, `full_name`, `password`, `username`) VALUES ('2', 'Md Rayhan Islam', '1234', 'rayhan');
INSERT INTO users_tbl (`id`, `full_name`, `password`, `username`) VALUES ('3', 'Mithila Rahaman', '123', 'mithila');


DROP VIEW IF EXISTS STATUS_VIEW;
CREATE VIEW STATUS_VIEW AS
    SELECT st.id,st.status_body,st.privacy_type,st.location_id,st.user_id,
    us.full_name, lc.title
FROM 
status_tbl st, users_tbl us, location_tbl lc 
WHERE 
st.user_id = us.id
and
st.location_id=lc.id;

