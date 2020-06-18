# spring-cloud-gateway-reactive-security-approach2
Spring Cloud Gateway - Reactive Security - Approach 2 - Using AuthenticationWebFilter, ServerAuthenticationConverter, ServerAuthenticationSuccessHandler

curl -X POST \
  http://localhost:8088/api/document \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -H 'Postman-Token: 818a0af7-aa11-47e5-a02b-8c4474141500' \
  -H 'cache-control: no-cache' \
  -d 'documentId=dummy-document-id&bearerToken=987654'
