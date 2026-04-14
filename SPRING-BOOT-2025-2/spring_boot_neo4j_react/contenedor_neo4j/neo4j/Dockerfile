FROM neo4j:5-enterprise

ENV NEO4J_ACCEPT_LICENSE_AGREEMENT=yes
ENV NEO4J_AUTH=neo4j/password123
ENV NEO4J_PLUGINS='["apoc"]'
ENV NEO4J_apoc_import_file_enabled=true
ENV NEO4J_apoc_export_file_enabled=true

EXPOSE 7474 7687

CMD ["neo4j"]

#         IMAGEN
#         docker build -t mi-neo4j .


#         CONTENEDOR
#         docker run -d -p 7474:7474 -p 7688:7687 --name neo4j-local mi-neo4j
