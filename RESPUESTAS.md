# Ejercicio de Modelado

La respuesta la puede encontrar dando click
[AQUI](./respuesta_modelado.pdf)

=====

# Ejercicio de desarrollo 


# Analisis:

![Alt text](./modelo.png?raw=true "Optional Title")

# Frontend Angular

Proyecto Angular visitar el repo bank-ui dando click
[AQUI](https://github.com/edcas/bank-ui) 

# Servicio

## Crear un titular como persona natural

Request:

```bash
curl -v -X POST \
  http://localhost:8080/api/v1/holders \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"cuit": "20-1234567-1",
	"document": "1234567",
	"first-name": "Joe",
	"last-name": "Doe"
}'

```

Response:
```bash
HTTP 201
```


# Crear un titular como persona juridica

Request:
```bash
curl -v -X POST \
  http://localhost:8080/api/v1/holders \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"cuit": "30-1234567-1",
	"business-name": "Cooperativa Tecso",
	"foundation-year": "2002"
}'
```

Response:
```bash
HTTP 201
```

# Consultar todos los titulares

Request:
```bash
curl -v -X GET \
  http://localhost:8080/api/v1/holders \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json'
```

# Obtener un titular

Request: 
```bash
curl -v -X GET \
  http://localhost:8080/api/v1/holders/1 \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json'
```

# Actualizar un titular como persona natural

Request:
```bash
curl -v -X PUT \
  http://localhost:8080/api/v1/holders/1 \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"cuit": "20-1234567-1",
	"document": "1234567",
	"first-name": "Richard",
	"last-name": "Doe"
}'
```

# Actualizar un titular como persona juridica

Request:
```bash
curl -v -X PUT \
  http://localhost:8080/api/v1/holders/2 \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
	"cuit": "30-1234567-1",
	"business-name": "Cooperativa Tecso SAS",
	"foundation-year": "2002"
}'
```

# Eliminar un titular

Request:
```bash
curl -v -X DELETE \
  http://localhost:8080/api/v1/holders/2 \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json'
```














