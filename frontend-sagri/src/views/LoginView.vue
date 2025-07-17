<template>
  <div class="login-container">
    <div class="login-box">
      <h1 class="empresa-nome">EMPRESA TESTE LTDA</h1>
      <p class="abertura-caixa">Abertura de Caixa: 08/07/2025</p>

      <form @submit.prevent="fazerLogin" class="formulario-login">
        <input v-model="nome" type="text" placeholder="Usuário" class="input" />
        <input v-model="senha" type="password" placeholder="Senha" class="input" />
        <Button label="Entrar" icon="pi pi-sign-in" severity="success" />
      </form>

      <p v-if="erro" class="erro">{{ erro }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import Button from 'primevue/button'
import axios from 'axios'

const router = useRouter()
const nome = ref('')
const senha = ref('')
const erro = ref('')

const fazerLogin = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/login', {
      nome: nome.value,
      senha: senha.value
    })

    if (response.data.success) {
      localStorage.setItem('usuario', JSON.stringify(response.data.usuario))
      router.push('/principal')
    } else {
      erro.value = response.data.message
    }
  } catch (e) {
    erro.value = 'Erro ao conectar com o servidor.'
  }
}
</script>

<style scoped>
.login-container {
  height: 100vh;
  background-image: url('/fundo-login.png');
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: flex-start;
  align-items: top;
  padding-top: 35px;
  padding-left: 40px;
}

.login-box {
  text-align: left;
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
  flex-direction: row;
  align-items: center;
  gap: 12px;
}

.input {
  padding: 10px;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  outline: none;
  background-color: rgba(240, 238, 146, 0.85);
  width: 250px;
}

.erro {
  color: red;
  margin-top: 10px;
}
</style>