FROM tomcat:10-jdk17


ADD target/marjane_franchise_promotion_manager-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/marjane_franchise_promotion_manager_war_exploded.war

RUN mkdir -p /usr/src/app
EXPOSE 8080


CMD ["catalina.sh","run"]