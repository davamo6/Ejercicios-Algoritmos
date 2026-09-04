# Ejercicios de algoritmos y estructuras de datos

Conjunto de ejercicios de diseño de algoritmos y estructuras de datos,
tema que se imparte tanto en la asignatura Algoritmos y Estructuras de
Datos (ALED) del Grado en Ingeniería Biomédica como en Análisis y
Diseño de Software (ADSW) del Grado en Ingeniería de Tecnologías y
Servicios de Telecomunicación.

Este repositorio contiene las **soluciones** a los ejercicios. Las
soluciones a los ejercicios del 2.1 al 2.10 están en forma de código,
cada una en su paquete correspondiente. Las soluciones a los
ejercicios del 3.1 al 3.10 aparecen a continuación. Intenta resolver
cada ejercicio por tu cuenta antes de consultar el código o las
respuestas; úsalos solo para comprobar tu propia solución, no como
punto de partida.

## Cómo importar el proyecto

Clona este repositorio e impórtalo en Eclipse como proyecto existente
(`.project` y `.classpath` ya están incluidos).

## Documentación

Los enunciados están en [`docs/Ejercicios-Algoritmos_Estructuras_Datos.pdf`](docs/Ejercicios-Algoritmos_Estructuras_Datos.pdf),
generado automáticamente a partir de su fuente LaTeX en Overleaf.

## Licencia

El código fuente (`src/`) se distribuye bajo licencia MIT. Consulta
[`LICENSE.md`](LICENSE.md).

Los enunciados y las respuestas (`docs/` y este README) se distribuyen
bajo licencia CC BY-NC-SA 4.0. Consulta
[`LICENSE-DOCS.md`](LICENSE-DOCS.md).

---

### 3.1. Variable contador

* **Valor final en función de N:**
    El bucle interno se ejecuta 0 veces cuando $i=0$, 1 vez cuando $i=1$, 2 veces cuando $i=2$, y así sucesivamente hasta $N-1$.
    Se trata de la suma de los primeros enteros: $0 + 1 + 2 + ... + (N-1)$.
    La fórmula matemática es la suma aritmética:
    $$\frac{(N-1)N}{2}$$
    O simplificado: $\frac{N^2 - N}{2}$.

* **Complejidad computacional:**
    Al dominar el término cuadrático $N^2$ en la fórmula anterior, la complejidad es **$O(N^2)$** (Cuadrática).

---

### 3.2. Método misterioso (I)

* **Estado del array tras $i=2$:**
    Array inicial: `{5, 2, 4, 6, 1, 3}`.
    * Iteración $i=1$ (Clave = 2): Se compara con 5, se desplaza el 5. Se inserta el 2. Array: `{2, 5, 4, 6, 1, 3}`.
    * Iteración $i=2$ (Clave = 4): Se compara con 5, se desplaza el 5. Se compara con 2, es mayor, se detiene. Se inserta el 4.
    * **Resultado:** `{2, 4, 5, 6, 1, 3}`.

* **Algoritmo:**
    Implementa **Insertion sort** ([ordenación por inserción](https://es.wikipedia.org/wiki/Ordenamiento_por_inserci%C3%B3n)).

* **Complejidad:**
    * **Caso peor:** $O(n^2)$ El array está ordenado al revés. El `while` interior se ejecuta completamente en cada paso.
    * **Caso mejor:** $O(n)$ El array ya está ordenado. La condición `datos[j] > clave` falla en la primera comprobación siempre, ejecutando el bucle interior 0 veces (tiempo constante por iteración externa).

---

### 3.3. Bucles anidados (I)

* **Valor final si $n=5$:**
    Suma: $5 (i=0) + 4 (i=1) + 3 (i=2) + 2 (i=3) + 1 (i=4) = 15$.

* **Ejecuciones en función de n:**
    El bucle interno arranca en $i$ y llega hasta $n-1$, así que se ejecuta $n-i$ veces:
    $$\sum_{i=0}^{n-1} (n - i) = n + (n-1) + ... + 1 = \frac{n(n+1)}{2}$$

* **Complejidad:**
    La complejidad es, de hecho, el número de ejecuciones de `contador++` en función de $n$: **$O(n^2)$**.

---

### 3.4. Búsqueda binaria modificada

* **Secuencia de valores de `medio`:**
    Array: `{2, 5, 8, 12, 16, 23, 38, 56, 72, 91}` (Índices 0-9). Buscando $x=23$.
    1.  `inicio=0`, `fin=9` $\rightarrow$ `medio` = 4 (Valor 16). $16 < 23$, buscar en derecha.
    2.  `inicio=5`, `fin=9` $\rightarrow$ `medio` = 7 (Valor 56). $56 > 23$, buscar en izquierda.
    3.  `inicio=5`, `fin=6` $\rightarrow$ `medio` = 5 (Valor 23). ¡Encontrado!
    **Secuencia:** 4, 7, 5.

* **Si no está ordenado:**
    El algoritmo **falla**. La búsqueda binaria asume que si $x$ es mayor que el medio, *debe* estar a la derecha. Sin orden, esta premisa es falsa y no encontrará el elemento correctamente.

* **Complejidad:**
    **$O(\log n)$**. En cada llamada recursiva, el espacio de búsqueda (`fin - inicio`) se divide por 2. El número de pasos es logarítmico respecto al tamaño del array.

---

### 3.5. Bucles anidados (II)

* **Ejecuciones si $n=10$:**
    * Bucle externo: 10 iteraciones.
    * Bucle interno ($j$ toma valores 1, 2, 4, 8): 4 iteraciones por cada vuelta externa.
    * Total aproximado: $10 \times 4 = 40$ veces.

* **Relación matemática:**
    El número de pasos del bucle interno es igual a $\log_2 n$ (redondeando hacia arriba), ya que $j$ crece exponencialmente ($2^k$) hasta llegar a $n$. Para $n=10$: $\log_2 10 \approx 3,32$, es decir, 4 pasos.

* **Complejidad:**
    El externo es $n$ y el interno es $\log n$. Al estar anidados se multiplican. **$O(n \cdot \log n)$**.

---

### 3.6. Bubble sort optimizado

* **Comparaciones con array ordenado:**
    Entrada: `{1, 2, 3, 4, 5}`.
    El bucle `i=0` recorre todo el array una vez. Hace 4 comparaciones (`j` de 0 a 3). Como nunca entra en el `if` (nunca intercambia), la variable `intercambiado` sigue `false` y hace `break`.
    **Respuesta:** 4 comparaciones (o $n-1$).

* **Variable `intercambiado`:**
    Sirve para detectar si el array ya está ordenado. Si se completa una pasada entera sin hacer ningún cambio, significa que no se necesita seguir ordenando y termina el algoritmo prematuramente para ahorrar tiempo.

* **Complejidad:**
    * **Caso mejor:** $O(n)$ Array ya ordenado (gracias a `intercambiado`, solo hace una pasada).
    * **Caso peor:** $O(n^2)$ Array ordenado inversamente. Debe realizar todas las pasadas y comparaciones posibles.
    Son diferentes porque la optimización permite saltarse pasos si detecta que los datos están ordenados.

---

### 3.7. Complejidad de un árbol N-ario

* **Análisis:**
    Para contar todos los nodos, el algoritmo debe visitar **cada nodo exactamente una vez**.
* **Complejidad:**
    **$O(n)$**, donde $n$ es el número total de nodos en el árbol. El trabajo es lineal respecto al tamaño de la estructura.

---

### 3.8. Método misterioso (II)

* **Qué calcula:**
    Calcula la **altura** (o profundidad máxima) del árbol.
    Toma la altura del subárbol más profundo (izquierdo o derecho) y le suma 1 (el nivel del nodo actual). Si el nodo es nulo, retorna 0 (altura base).

---

### 3.9. Árbol binario degenerado

* **Complejidad de búsqueda (caso peor):**
    En un árbol degenerado, no se puede descartar la mitad de los nodos en cada paso (el árbol no está equilibrado). Hay que recorrer los nodos uno a uno. Complejidad: **$O(n)$** (lineal).

* **Caso mejor:**
    El elemento buscado es la raíz del árbol. Complejidad: **$O(1)$**.

---

### 3.10. Complejidad de método recursivo

* **Llamadas para $n=3$:**
    * $n=3$: 1 llamada. Imprime 3 y llama a (2) y (2).
    * $n=2$: 2 llamadas. Imprimen 2 y llaman a (1) y (1). Total 4 llamadas a $n=1$.
    * $n=1$: 4 llamadas. Imprimen 1 y llaman a (0) y (0). Total 8 llamadas a $n=0$.
    * $n=0$: 8 llamadas. Solo comprueban la condición de parada y retornan.
    Cada nivel duplica el número de llamadas, así que se trata de una progresión geométrica: $2^0 + 2^1 + 2^2 + 2^3 = 2^{n+1} - 1$.
    **Total: 15 llamadas**, de las cuales 7 hacen trabajo (imprimen y vuelven a llamar) y 8 son casos base.

* **Complejidad:**
    Cada paso duplica el número de operaciones. **$O(2^n)$** (Exponencial).
