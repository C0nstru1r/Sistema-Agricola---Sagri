import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

import PrimeVue from 'primevue/config';
import Aura from '@primeuix/themes/aura'; // tema novo
import 'primeicons/primeicons.css';

import Button from 'primevue/button';

const app = createApp(App);

app.use(router);

// ✅ Aqui está a nova forma de ativar o tema moderno
app.use(PrimeVue, {
  theme: {
    preset: Aura
  }
});

app.component('Button', Button);

app.mount('#app');