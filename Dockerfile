FROM maven:3-alpine

LABEL maintainer = "Hüseyin Akdoğan <hakdogan@kodcu.com>"

COPY pom.xml Shiro/

COPY src/ Shiro/src/

COPY run.sh Shiro/run.sh

WORKDIR Shiro/

RUN mvn clean install

EXPOSE 9080

ENTRYPOINT ["sh", "./run.sh"]