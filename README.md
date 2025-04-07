<!--- ![Image](https://github.com/user-attachments/assets/e521d1cf-6e01-49c9-a9af-f2f458979635) --->

# 🕒 **Relógio de Ponteiro Digital**

<div align="center">
  <img src="https://github.com/user-attachments/assets/e521d1cf-6e01-49c9-a9af-f2f458979635">
</div>  

---

## 📌 **Sobre o projeto:**
Este projeto é uma implementação de um "relógio analógico-digital", onde os ponteiros não são representados por linhas, mas sim por números dinâmicos que indicam a medida do tempo correspondente ao seu respectivo ponteiro. O relógio exibe horas, minutos e segundos em tempo real, além da data e do período do dia. 

⏱️ A hora exibida pelo relógio é obtida diretamente do sistema operacional, garantindo que o relógio esteja sempre sincronizado com a hora local configurada no seu computador (como o Windows, por exemplo).

---

## 🖥️ **Tecnologias utilizadas:**
- **Linguagem:** Java  
- **IDE:** IntelliJ IDEA Community  
- **SDK:** Java 17  
- **Interface Gráfica:** Swing e AWT

---

## 🎯 **Principais características:**  
✅ Ponteiros formados por números dinâmicos  
✅ Exibição do dia e do mês no formato `DD (Nome do mês)`  
✅ Indicação de período do dia (Dia/Noite)  
✅ Renderização gráfica com `Swing` e `AWT`

---

## 🚀 **Como Executar**

### ✅ Pré-requisitos:
- Ter o **Java 17** instalado e configurado no sistema  
- (Opcional, mas recomendado) Ter o **IntelliJ IDEA Community Edition** instalado para facilitar a execução

### 💻 **Executar via IntelliJ IDEA:**
1. Abra o IntelliJ IDEA  
2. Vá em **File > Open...** e selecione a pasta `relogio-de-ponteiro-digital`  
3. Aguarde a indexação e o carregamento do projeto  
4. Navegue até o arquivo `Clock.java`, localizado dentro da pasta `src` (que contém os códigos-fonte)  
5. Clique com o botão direito no arquivo `Clock.java` e selecione **Run 'Clock.main()'**  
6. O relógio será aberto em uma janela gráfica

### 🖥️ **Executar via terminal (linha de comando):**
💡 **Dica:** O terminal é uma interface onde você digita comandos diretamente para o sistema. No Windows, pode ser o **Prompt de Comando**, o **PowerShell**, ou o **Git Bash** (instalado junto com o Git). Você também pode usar o terminal interno do IntelliJ.

1. Abra o terminal no seu sistema.  
2. Navegue até a pasta do projeto com o comando:

```bash
cd caminho/para/relogio-de-ponteiro-digital
```

3. Compile o arquivo Java  
> Isso transforma o código-fonte (`.java`) em um arquivo que o computador pode entender (`.class`):

```bash
javac src/Clock.java -d out/production/relogio-de-ponteiro-digital
```

4. Execute o programa  
> Isso faz com que o programa seja iniciado e exibido na tela:

```bash
java -cp out/production/relogio-de-ponteiro-digital Clock
```
