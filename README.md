# intervals
DISEÑO CASOS DE PRUEBA
isIntersected()

NO INTERSECTAN ➖

	---{----}------------
	------------{----}---

	----------{----}-----
	-{----}--------------

	---------{---}------- NO INTERSECTAN EN OPEN
	-----{---}-----------

	-{---}--------------- NO INTERSECTAN EN OPEN
	-----{---}-----------

INTERSECTAN ✖

	EL INTERVALO CONTIENE O BIEN MINIO O MAXIMO
	---{---------}------- CONTIENE MINIMO ✔
	----------{------}---

	----------{------}--- CONTIENE MAXIMO ✔
	-------{-----}-------

	ENTRAN EN EL MISMO CASO 
	---{---------}------- CONTIENE MINIMO Y MAXIMO
	-----{---}-----------

	---{---------}------- CONTIENE MAXIMO || CONTIENE MINIMO EN CLOSED
	---{---}-------------

	---{-------------}--- CONTIENE MINIMO || CONTIENE MAXIMO EN CLOSED
	-----------{-----}---

	EN CASO DE CLOSED ENTRAN EN EL MISMO CASO
	---------{---}------- INTERSECTAN EN CLOSED
	-----{---}-----------

	-{---}--------------- INTERSECTAN EN CLOSED
	-----{---}-----------

	EL MINIMO DEL INTERVALO ES IGUAL AL MINIMO DEL INTERVALO A COMPARAR
	EL MAXIMO DEL INTERVALO ES IGUAL AL MAXIMO DEL INTERVALO A COMPARAR
	---{-----}----------- EN OPEN NO CONTIENE NI MINIMO NI MAXIMO, PERO PARAMETRO CONTIENE MAXIMO || EN CLOSED CONTIENE MINIMO
	---{----------}------

	----------------{}--- EN OPEN NO CONTIENE NI MINIMO NI MAXIMO, PERO PARAMETRO CONTIENE MINIMO || EN CLOSED MAXIMO
	----------{------}---

	---{---------}------- EN OPEN NO CONTIENE NI MINIMO NI MAXIMO || EN CLOSED CONTIENE MINIMO Y MAXIMO
	---{---------}-------


	-----{---}----------- NO CONTIENE NI MINIMO NI MAXIMO, PERO PARAMETRO CONTIENE MINIMO Y MAXIMO ✔
	---{---------}-------