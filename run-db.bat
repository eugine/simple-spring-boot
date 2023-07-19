docker run -d -e POSTGRES_USER=demo -e POSTGRES_PASSWORD=demo -p 5432:5432  -v postgres-data:/var/lib/postgresql/data postgres:15.2
