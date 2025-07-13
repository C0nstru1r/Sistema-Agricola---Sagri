<template>
  <div class="login-container">
    <div class="login-box">
      <h1 class="empresa-nome">EMPRESA TESTE LTDA</h1>
      <p class="abertura-caixa">Abertura de Caixa: 08/07/2025</p>

      <form class="formulario-login">
        <input type="text" placeholder="Usuário" class="input" />
        <input type="password" placeholder="Senha" class="input" />
        <Button type="submit" label="Entrar" icon="pi pi-sign-in" size="small" severity="success" />
      </form>
    </div>
  </div>
</template>

<script setup>
// Se o componente Button foi registrado globalmente em main.ts,
// não é necessário importar aqui.
</script>

<style scoped>
.login-container {
  height: 100vh;
  background-image: url('/fundo-login.png');
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
}

.login-box {
  text-align: center;
  color: rgb(4, 3, 85);
}

.empresa-nome {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 8px;
  text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.7);
}

.abertura-caixa {
  font-size: 14px;
  margin-bottom: 24px;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.6);
}

.formulario-login {
  display: flex;
  flex-direction: column;
  gap: 16px;
  width: 250px;
  align-items: stretch;
}

.input {
  padding: 10px;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  outline: none;
  background-color: rgba(240, 238, 146, 0.85);
}
</style>