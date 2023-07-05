docker run -d \
  -e POSTGRES_USER=demo \
  -e POSTGRES_PASSWORD=demo \
  -p 5432:5432 \
  postgres:15.2
