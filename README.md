# Reto 3

**Arquitectura, estilo MVC (Model-View-Controller) con paquete Command:**
La estructura del proyecto separa claramente las responsabilidades. En el paquete **model**, la clase `JoltageSequence` (implementada como un `Record`) encapsula la lógica algorítmica fundamental: buscar la subsecuencia numérica máxima dentro de una cadena de texto respetando el orden. En el paquete **view**, `CalibrationDisplay` se limita a mostrar el resultado final. En **controller**, `CalibrationController` actúa como intermediario, recibiendo los datos crudos y coordinando la ejecución del proceso mediante comandos.

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Cada clase tiene una función específica y aislada. `TextFileReader` solo lee archivos, `JoltageSequence` solo sabe buscar máximos en una cadena, y `CalculateCalibrationCommand` solo organiza el cálculo masivo.
* **Inversión de Dependencias (DIP):** El código depende de abstracciones como `InputReader` y `SolutionPrinter`, lo que permite cambiar la fuente de datos (ej. leer de una API) o la salida (ej. escribir en un archivo) sin modificar la lógica de negocio.
* **Abierto-Cerrado (OCP):** El diseño es flexible. Gracias a que la longitud de búsqueda (`targetLength`) se pasa como parámetro al Factory Method `withDigitLength`, el sistema puede adaptarse para buscar secuencias de 2, 12 o 100 dígitos sin alterar el código interno de la clase `CalibrationController`.

**Extras:**
* **Clase Command:** La clase `CalculateCalibrationCommand` encapsula la lógica de iterar sobre todas las secuencias y sumar sus resultados, desacoplando esta operación del controlador.
* **Java Records:** Uso de `JoltageSequence` para crear objetos de datos inmutables de forma poco verbosa.
* **Algoritmo Greedy (Voraz):** Implementación eficiente en `extractMaxCalibrationValue` que busca localmente el mejor dígito posible en cada paso para construir el número global más alto.
* **Streams:** Uso de `map`, `mapToLong` y `sum` para procesar listas de datos de manera funcional y concisa.
