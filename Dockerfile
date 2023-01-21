#Dockerfile
FROM logstash:7.9.3

COPY --chown=admin:admin  /logstash/ /usr/share/logstash/pipeline/
CMD ["-f", "/usr/share/logstash/pipeline/logstash.conf"]