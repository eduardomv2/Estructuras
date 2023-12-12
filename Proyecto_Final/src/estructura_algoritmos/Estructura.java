package estructura_algoritmos;
import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
public class Estructura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para las estructuras de datos
        Pila pila = new Pila();
        Cola cola = new Cola();
        Lista lista = new Lista();
        Arbol arbol = new Arbol();
        Grafo grafo = new Grafo();

        int opcion;
        do {
            System.out.println("Elija una estructura de datos:");
            System.out.println("1. Pila");
            System.out.println("2. Cola");
            System.out.println("3. Lista");
            System.out.println("4. Árbol");
            System.out.println("5. Grafo");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    manejarPila(scanner, pila);
                    break;
                case 2:
                    manejarCola(scanner, cola);
                    break;
                case 3:
                    manejarLista(scanner, lista);
                    break;
                case 4:
                    manejarArbol(scanner, arbol);
                    break;
                case 5:
                    manejarGrafo(scanner, grafo);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }
    
   

    // Clase Pila
    static class Pila {
        private Stack<Integer> stack = new Stack<>();

        public void push(int elemento) {
            stack.push(elemento);
            
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void verElementos() {
            System.out.println("Contenido de la pila: " + stack);
        }
    }

    // Clase Cola
    static class Cola {
    	private Queue<Integer> cola = new LinkedList<>();

        public void enqueue(int elemento) {
            cola.add(elemento);
            System.out.println("Se ha ingresado el dato " + elemento + " en la cola.");
        }

        public int dequeue() {
            if (!cola.isEmpty()) {
                int removedData = cola.poll();
                System.out.println("Se ha retirado el dato " + removedData + " de la cola.");
                return removedData;
            } else {
                System.out.println("La cola está vacía, no se pueden retirar más datos.");
                return -1; // Puedes devolver un valor especial para indicar un error o manejarlo de otra manera.
            }
        }

        public int peek() {
            if (!cola.isEmpty()) {
                int frontData = cola.peek();
                System.out.println("El primer dato en la cola es: " + frontData);
                return frontData;
            } else {
                System.out.println("La cola está vacía, no hay datos para mostrar.");
                return -1;
            }
        }

        public boolean isEmpty() {
            return cola.isEmpty();
        }

        public void verElementos() {
            System.out.println("Contenido de la cola: " + cola);
        }
    }

    // Clase Lista
    static class Lista {
    	 private List<Integer> lista = new ArrayList<>();

         public void agregar(int elemento) {
             lista.add(elemento);
             System.out.println("Se ha ingresado el dato " + elemento + " en la lista.");
         }

         public void eliminar(int indice) {
             if (indice >= 0 && indice < lista.size()) {
                 int removedData = lista.remove(indice);
                 System.out.println("Se ha eliminado el dato " + removedData + " en la posición " + indice + " de la lista.");
             } else {
                 System.out.println("Índice no válido. No se puede eliminar el dato.");
             }
         }

         public int obtener(int indice) {
             if (indice >= 0 && indice < lista.size()) {
                 int data = lista.get(indice);
                 System.out.println("El dato en la posición " + indice + " de la lista es: " + data);
                 return data;
             } else {
                 System.out.println("Índice no válido. No hay datos para mostrar.");
                 return -1;
             }
         }

         public boolean isEmpty() {
             return lista.isEmpty();
         }

         public void verElementos() {
             System.out.println("Contenido de la lista: " + lista);
         }
    }

    // Clase Árbol
    static class Arbol {   	      
            private Nodo raiz;

            static class Nodo {
                int dato;
                List<Nodo> hijos;

                Nodo(int dato) {
                    this.dato = dato;
                    this.hijos = new ArrayList<>();
                }
            }

            public void insertar(int dato) {
                if (raiz == null) {
                    raiz = new Nodo(dato);
                } else {
                    // En este ejemplo, los nodos se agregan como hijos del primer nodo
                    raiz.hijos.add(new Nodo(dato));
                }
                System.out.println("Se ha ingresado el dato " + dato + " en el árbol.");
            }

            public void verElementos() {
                System.out.println("Contenido del árbol: ");
                mostrarNodos(raiz, 0);
            }

            private void mostrarNodos(Nodo nodo, int nivel) {
                if (nodo != null) {
                    for (int i = 0; i < nivel; i++) {
                        System.out.print("  "); // Agrega espacios para visualizar la jerarquía
                    }
                    System.out.println(nodo.dato);
                    for (Nodo hijo : nodo.hijos) {
                        mostrarNodos(hijo, nivel + 1);
                    }
                }
            }
    	}

    // Clase Grafo
    static class Grafo {
    	  private List<Vertice> vertices;
          private List<Arista> aristas;

          static class Vertice {
        	    int dato;

        	    Vertice(int dato) {
        	        this.dato = dato;
        	    }

        	    @Override
        	    public String toString() {
        	        return Integer.toString(dato);
        	    }
        	}

        	static class Arista {
        	    Vertice origen;
        	    Vertice destino;

        	    Arista(Vertice origen, Vertice destino) {
        	        this.origen = origen;
        	        this.destino = destino;
        	    }

        	    @Override
        	    public String toString() {
        	        return "(" + origen + " -> " + destino + ")";
        	    }
        	}

          Grafo() {
              this.vertices = new ArrayList<>();
              this.aristas = new ArrayList<>();
          }

          public void agregarVertice(int dato) {
              vertices.add(new Vertice(dato));
              System.out.println("Se ha ingresado el vértice " + dato + " en el grafo.");
          }

          public void agregarArista(int datoOrigen, int datoDestino) {
              Vertice origen = encontrarVertice(datoOrigen);
              Vertice destino = encontrarVertice(datoDestino);

              if (origen != null && destino != null) {
                  aristas.add(new Arista(origen, destino));
                  System.out.println("Se ha ingresado la arista entre " + datoOrigen + " y " + datoDestino + ".");
              } else {
                  System.out.println("No se encontraron los vértices correspondientes para agregar la arista.");
              }
          }

          private Vertice encontrarVertice(int dato) {
              for (Vertice vertice : vertices) {
                  if (vertice.dato == dato) {
                      return vertice;
                  }
              }
              return null;
          }

          public void verElementos() {
              System.out.println("Vértices del grafo: " + vertices);
              System.out.println("Aristas del grafo: " + aristas);
          }
    }

    // Resto del código...

    // Método para manipular la Pila
    private static void manejarPila(Scanner scanner, Pila pila) {
        while (true) {
        	
            System.out.println("Opciones:");
            System.out.println("1. Push (Ingresar dato)");
            System.out.println("2. Pop (Quitar dato)");
            System.out.println("3. Peek (Ver último dato)");
            System.out.println("4. Mostrar Pila Completa");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Push (Ingresar dato)
                    System.out.print("Ingrese un número: ");
                    int newData = scanner.nextInt();
                    pila.push(newData);
                    System.out.println("Se ha ingresado el dato " + newData + " en la pila.");
                    
                    break;

                case 2: // Pop (Quitar dato)
                    if (!pila.isEmpty()) {
                        int poppedData = pila.pop();
                        System.out.println("Se ha retirado el dato " + poppedData + " de la pila.");
                    } else {
                        System.out.println("La pila está vacía, no se pueden retirar más datos.");
                    }
                    break;

                case 3: // Peek (Ver último dato)
                    if (!pila.isEmpty()) {
                        int peekedData = pila.peek();
                        System.out.println("El último dato ingresado en la pila es: " + peekedData);
                    } else {
                        System.out.println("La pila está vacía, no hay datos para mostrar.");
                    }
                    break;

                case 4: // Mostrar Pila Completa
                    pila.verElementos();
                    break;

                case 5: // Salir
                    return; // Regresar al menú principal

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }
        
    }
    private static void manejarCola(Scanner scanner, Cola cola) {
    	while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Encolar dato");
            System.out.println("2. Desencolar dato");
            System.out.println("3. Ver primer dato");
            System.out.println("4. Mostrar Cola");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Encolar dato
                    System.out.print("Ingrese un número: ");
                    int newData = scanner.nextInt();
                    cola.enqueue(newData);
                    break;

                case 2: // Desencolar dato
                    cola.dequeue();
                    break;

                case 3: // Ver primer dato
                    cola.peek();
                    break;

                case 4: // Mostrar Cola
                    cola.verElementos();
                    break;

                case 5: // Salir
                    return; // Regresar al menú principal

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
    
    private static void manejarLista(Scanner scanner, Lista lista) {
    	while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Agregar dato");
            System.out.println("2. Eliminar dato");
            System.out.println("3. Obtener dato");
            System.out.println("4. Mostrar Lista");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Agregar dato
                    System.out.print("Ingrese un número: ");
                    int newData = scanner.nextInt();
                    lista.agregar(newData);
                    break;

                case 2: // Eliminar dato
                    System.out.print("Ingrese el índice del dato a eliminar: ");
                    int indexToRemove = scanner.nextInt();
                    lista.eliminar(indexToRemove);
                    break;

                case 3: // Obtener dato
                    System.out.print("Ingrese el índice del dato a obtener: ");
                    int indexToGet = scanner.nextInt();
                    lista.obtener(indexToGet);
                    break;

                case 4: // Mostrar Lista
                    lista.verElementos();
                    break;

                case 5: // Salir
                    return; // Regresar al menú principal

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
    
    private static void manejarArbol(Scanner scanner, Arbol arbol) {
    	 while (true) {
             System.out.println("Opciones:");
             System.out.println("1. Insertar dato");
             System.out.println("2. Mostrar Árbol");
             System.out.println("3. Salir");
             System.out.print("Elija una opción: ");
             int choice = scanner.nextInt();

             switch (choice) {
                 case 1: // Insertar dato
                     System.out.print("Ingrese un número: ");
                     int newData = scanner.nextInt();
                     arbol.insertar(newData);
                     break;

                 case 2: // Mostrar Árbol
                     arbol.verElementos();
                     break;

                 case 3: // Salir
                     return; // Regresar al menú principal

                 default:
                     System.out.println("Opción no válida. Por favor, elija una opción válida.");
                     break;
             }
         }
    }
    private static void manejarGrafo(Scanner scanner, Grafo grafo) {
    	 while (true) {
             System.out.println("Opciones:");
             System.out.println("1. Agregar vértice");
             System.out.println("2. Agregar arista");
             System.out.println("3. Mostrar Grafo");
             System.out.println("4. Salir");
             System.out.print("Elija una opción: ");
             int choice = scanner.nextInt();

             switch (choice) {
                 case 1: // Agregar vértice
                     System.out.print("Ingrese el dato del vértice: ");
                     int newVertex = scanner.nextInt();
                     grafo.agregarVertice(newVertex);
                     break;

                 case 2: // Agregar arista
                     System.out.print("Ingrese el dato del vértice origen: ");
                     int originVertex = scanner.nextInt();
                     System.out.print("Ingrese el dato del vértice destino: ");
                     int destinationVertex = scanner.nextInt();
                     grafo.agregarArista(originVertex, destinationVertex);
                     break;

                 case 3: // Mostrar Grafo
                     grafo.verElementos();
                     break;

                 case 4: // Salir
                     return; // Regresar al menú principal

                 default:
                     System.out.println("Opción no válida. Por favor, elija una opción válida.");
                     break;
             }
         }
    }
    
    
}
