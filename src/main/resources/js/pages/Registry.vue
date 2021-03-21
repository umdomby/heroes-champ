<template>

  <v-container>

    <v-layout align-space-around justify-start column>
      <div v-for="user in sortedUsers">
<!--        {{ user.id }} -->
        {{ user.name }}
      </div>
    </v-layout>

    <v-layout>
      <form class="card">
        <h2>Settings account</h2>
        <div class="form-control">
          <label for="name">Name:</label>
          <input type="text" id="name" v-model.trim="name">
        </div>
        <button class="btn primary" :disabled="name.length === 0">Add login Heroes</button>
      </form>
    </v-layout>

  </v-container>


</template>

<script>

import {mapGetters} from 'vuex'


export default {
  name: 'Registry',
  data() {
    return {
      user: null,
      name: '',
    }
  },
  computed: mapGetters(
      ['sortedUsers']
  ),

}
</script>

<style scoped>

</style>
