<template>
  <v-card class="my-0">
<!--    <v-card-text>-->

      <v-btn icon @click="del" small>
        <v-icon>delete</v-icon>
      </v-btn>
    
      <v-btn value="Edit" @click="edit" small flat round>Edit</v-btn>
      <i>({{ champ.id }})</i>
      {{ champ.text }}

<!--    </v-card-text>-->

<!--    <v-card-actions>-->
<!--    </v-card-actions>-->
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
