<template>
  <v-card class="my-0">
      <v-btn icon @click="del" small>
        <v-icon>delete</v-icon>
      </v-btn>
    
      <v-btn value="Edit" @click="edit" small flat round>Edit</v-btn>
      ({{ champ.id }}) {{ champ.text }}
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: ['champ', 'editChamp'],
  methods: {
    ...mapActions(['removeChampAction']),
    edit() {
      this.editChamp(this.champ)
    },
    del() {
      this.removeChampAction(this.champ)
    }
  }
}
</script>

<style>

</style>
