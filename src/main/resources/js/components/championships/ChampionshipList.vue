<template>

    <v-layout row wrap>
      <v-flex  v-for="champions in sortedChampionships" xs3>
        <v-card dark color="secondary" >
          <v-card-text class="px-2">
            {{champions.id}}
            {{champions.champoff}}
            {{champions.name}}

            <v-btn @click="save">
              {{champions.champoff ? 'true' : 'false'}}
            </v-btn>

          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>

</template>

<script>
import {mapActions, mapGetters} from 'vuex'

export default {
  props: ['championshipAttr'],
  data() {
    return {
      champoff: '',
      id: ''
    }
  },
  watch: {
    championshipAttr(newVal, oldVal) {
      this.champoff = !newVal
    }
  },
  computed: mapGetters(['sortedChampionships']),
  methods: {
    ...mapActions(['updateChampionshipAction']),
    save() {
      const championship = {
        champoff: this.champoff
      }

      if (this.id) {
        this.updateChampionshipAction(championship)
      }
      // else {
      //   this.addChampAction(champ)
      // }

     }

  }

}
</script>

<style>

</style>
