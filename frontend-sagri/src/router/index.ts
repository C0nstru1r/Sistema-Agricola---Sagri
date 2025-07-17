import { createRouter, createWebHistory } from "vue-router";
import LoginView from "@/views/LoginView.vue";
import PaginaPrincipal from "@/pages/PaginaPrincipal.vue";

const routes = [
  {
    path: '/',
    name: 'Login',
    component: LoginView
  },
  {
    path: '/principal',
    name: 'PaginaPrincipal',
    component: PaginaPrincipal,
    meta: { requiresAuth: true }
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

// Proteção de rota
router.beforeEach((to, from, next) => {
  const usuario = JSON.parse(localStorage.getItem('usuario') || 'null');
  if (to.meta.requiresAuth && !usuario) {
    next({ name: 'Login' });
  } else {
    next();
  }
});

export default router;