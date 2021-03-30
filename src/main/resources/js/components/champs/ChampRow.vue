<template>

    <v-card class="my-1">

      <v-card-actions >

        <v-btn class="mr-1" @click="save">edit</v-btn>
        <v-btn icon @click="del" small>
          <v-icon>delete</v-icon>
        </v-btn>
        <i class="mr-3 ml-2">({{ champ.id }})</i>

<!--        <input type="text" v-model="champ.text">-->
  <!--      <v-btn value="Edit" @click="edit" small flat round>Edit</v-btn>-->

        <v-text-field @keyup.enter="save" v-model="champ.text"/>
      </v-card-actions>
    </v-card>

</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: ['champ', 'editChamp'],
  methods: {
    ...mapActions(['removeChampAction', 'updateChampAction']),
    edit() {
      this.editChamp(this.champ)
    },
    del() {
      this.removeChampAction(this.champ)
    },
    save() {
      const champ = {
        id: this.champ.id,
        text: this.champ.text
      }

      // if (this.id) {
        this.updateChampAction(champ)
      // } else {
      //   this.addChampAction(champ)
      // }

      this.text = ''
      this.id = ''
    }
  }
}
</script>

<style>

</style>
