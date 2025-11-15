## NOTAÇÃO DE GRAFO DE FLUXO

### **Nós (N)**  
Total: 13

N1 – Início do método conectarBD()  
N2 – Entrada no bloco try  
N3 – Carregar driver, montar URL e abrir conexão  
N4 – Bloco catch de conectarBD()  
N5 – return conn  

N6 – Início do método verificarUsuario()  
N7 – Montagem da instrução SQL  
N8 – Execução do try (createStatement e executeQuery)  
N9 – Decisão: if(rs.next())  
N10 – Caminho TRUE (lê nome e result=true)  
N11 – Caminho FALSE (segue o fluxo sem alterações)  
N12 – Bloco catch de verificarUsuario()  
N13 – return result  


### **Arestas (E)**  
Total: 14

**conectarBD():**  
N1 → N2  
N2 → N3  
N2 → N4  
N3 → N5  
N4 → N5  

**verificarUsuario():**  
N6 → N7  
N7 → N8  
N8 → N9  
N9 → N10  
N9 → N11  
N10 → N13  
N11 → N13  
N8 → N12  
N12 → N13  

---

## COMPLEXIDADE CICLOMÁTICA

**Fórmula:**  
M = E – N + 2P

**Valores:**  
E = 14  
N = 13  
P = 1

**Cálculo:**  
M = 14 – 13 + 2(1)  
M = **3**

**Complexidade Ciclomática: 3**

---

## CAMINHOS BÁSICOS

Como a complexidade ciclomática é M = 3, existem 3 caminhos básicos independentes:

**Caminho 1:**  
N6 → N7 → N8 → N9 → N10 → N13  

**Caminho 2:**  
N6 → N7 → N8 → N9 → N11 → N13  

**Caminho 3:**  
N6 → N7 → N8 → N12 → N13  
