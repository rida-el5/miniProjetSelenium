# language: fr
  Fonctionnalité: Achat d’un Moisturizers
    Scénario: Achat d’un Moisturizers
      Soit Je me connecte au page home
      Lorsque Je clique sur le bouton Buy moisturizers
      Et Je check si je me suis redirigé vers la page Moisturizers
      Et Je check que chaque produit est affiché avec son titre et son prix
      Et J’ajoute le premier produit à mon panier
      Et Je check que le panier contient un item
      Et Je clique sur carte
      Et Je check si le produit ajouté correspond bien à mon produit (titre , prix , total)
      Et Je clique sur le bouton Pay with card
      Et Je check si la popup Stripe.com s’affiche
      Et Je saisis les informations nécessaires pour compléter l’achat (email, card number , date , cvc, zip code)
      Et Je clique sur le bouton pay iner
      Alors Je check si le message Your payment was successful. You should receive a follow-up call from our sales team est bien affiché