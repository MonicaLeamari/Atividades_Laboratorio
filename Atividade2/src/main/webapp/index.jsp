<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Calculadora Servlet</title>
</head>
<body>
 
  <style>
  body {
  background-color: #f8f9fa;
  font-family: Arial, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.container {
  background-color: #ffffff;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  text-align: center;
  width: 300px;
}

h2 {
  margin-bottom: 20px;
  color: #333;
}

input, select, button {
  width: 50%;
  padding: 10px;
  margin: 10px 0;
  border-radius: 6px;
  border: 1px solid #ccc;
  font-size: 16px;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
  </style>
  <div class = "container">
   <h2>Calculadora</h2>
  
  <form action="calc" method="post">
    <input type="number" name="num1" required>
    <select name="operador">
      <option value="+">+</option>
      <option value="-">-</option>
      <option value="*">*</option>
      <option value="/">/</option>
    </select>
    <input type="number" name="num2" required>
    <button type="submit">Calcular</button>
  </form>
  </div>
  
  <c:if test="${not empty resultado}">
  <div class="container">
    <h2>Resultado: ${resultado}</h2>
  </div>
</c:if>
</body>
</html>