USE arif_travel_agencydb;
-- Insert Role init data
INSERT INTO `arif_travel_agencydb`.roles_tbl (`id`, `description`, `is_deleted`, `name`) VALUES ('99999990', 'Role for User', '0', 'ROLE_USER');

-- Insert Location init data
INSERT INTO `arif_travel_agencydb`.location_tbl (`id`, `is_active`, `title`) VALUES ('99999999', '1', 'Sylhet');
INSERT INTO `arif_travel_agencydb`.location_tbl (`id`, `is_active`, `title`) VALUES ('99999998', '1', 'Bandarban');
INSERT INTO `arif_travel_agencydb`.location_tbl (`id`, `is_active`, `title`) VALUES ('99999997', '1', 'Khulna');

-- Create Status View
DROP TABLE IF EXISTS `arif_travel_agencydb`.STATUS_VIEW;
DROP VIEW IF EXISTS `arif_travel_agencydb`.STATUS_VIEW;
CREATE VIEW STATUS_VIEW AS
    SELECT st.id,st.status_body,st.privacy_type,st.location_id,st.user_id,
    us.full_name, lc.title
FROM 
status_tbl st, users_tbl us, location_tbl lc 
WHERE 
st.user_id = us.id
and
st.location_id=lc.id;

