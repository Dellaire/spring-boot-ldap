# Starting Open LDAP

docker run -p 389:389 -p 636:636 -e LDAP_ORGANISATION="company" -e LDAP_DOMAIN="company" -e 
LDAP_READONLY_USER="true" -e LDAP_READONLY_USER_USERNAME="user" -e LDAP_READONLY_USER_PASSWORD="user" -e 
LDAP_ADMIN_PASSWORD="admin" osixia/openldap:1.3.0 --loglevel debug