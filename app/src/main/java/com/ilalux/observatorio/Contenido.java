package com.ilalux.observatorio;

/**
 * Contenido de la app. Formato de cada linea del cuerpo:
 *   "## Titulo"  -> subtitulo
 *   "• Texto"    -> vineta
 *   otro texto   -> parrafo
 */
final class Contenido {
    static final class Item {
        final String etiqueta, titulo, resumen;
        final String[] cuerpo;
        Item(String etiqueta, String titulo, String resumen, String... cuerpo) {
            this.etiqueta = etiqueta; this.titulo = titulo;
            this.resumen = resumen; this.cuerpo = cuerpo;
        }
    }

    static final Item[] TEMARIO = {
        new Item("MÓDULO 1", "Introducción a la astronomía",
            "Historia, el cielo nocturno y las constelaciones.",
            "La astronomía es la ciencia que estudia los astros: su origen, su movimiento y su evolución. Es una de las ciencias más antiguas, pues desde la antigüedad las culturas observaron el cielo para medir el tiempo, orientarse y organizar sus calendarios.",
            "## Temas del módulo",
            "• Breve historia: de la observación a simple vista al telescopio, con Galileo en 1609, hasta los observatorios modernos.",
            "• El cielo en Mesoamérica: mayas y mexicas desarrollaron calendarios basados en el Sol, la Luna y Venus.",
            "• La esfera celeste: por qué el cielo parece girar, y qué son el horizonte, el cenit y los puntos cardinales.",
            "• Constelaciones y asterismos: grupos de estrellas que sirven de mapa, como Orión, la Osa Mayor o Escorpión.",
            "## Actividad práctica",
            "Sal a un lugar oscuro, deja que tus ojos se adapten durante 15 minutos e intenta identificar tres constelaciones sin ayuda de instrumentos."),

        new Item("MÓDULO 2", "El Sistema Solar",
            "El Sol, planetas, lunas, asteroides y cometas.",
            "El Sistema Solar se formó hace unos 4,600 millones de años a partir de una nube de gas y polvo. Está compuesto por una estrella, ocho planetas, sus lunas, planetas enanos, asteroides y cometas.",
            "## Temas del módulo",
            "• El Sol: una estrella que concentra más del 99 % de la masa de todo el sistema.",
            "• Planetas rocosos: Mercurio, Venus, la Tierra y Marte.",
            "• Gigantes gaseosos y helados: Júpiter, Saturno, Urano y Neptuno.",
            "• Cuerpos menores: planetas enanos como Plutón y Ceres, el cinturón de asteroides y los cometas.",
            "## Dato curioso",
            "La luz del Sol tarda unos 8 minutos y 20 segundos en llegar a la Tierra."),

        new Item("MÓDULO 3", "La Luna y sus fases",
            "Eclipses, mareas y observación lunar.",
            "La Luna es el único satélite natural de la Tierra y se encuentra a unos 384,400 km de distancia. Completa su ciclo de fases en aproximadamente 29.5 días.",
            "## Las fases",
            "Luna nueva, creciente, cuarto creciente, gibosa creciente, llena, gibosa menguante, cuarto menguante y menguante. Las fases no son la sombra de la Tierra: dependen de cuánta parte de la mitad iluminada de la Luna vemos desde aquí.",
            "## Eclipses",
            "• Eclipse solar: la Luna se interpone entre el Sol y la Tierra (ocurre en Luna nueva).",
            "• Eclipse lunar: la Tierra se interpone entre el Sol y la Luna (ocurre en Luna llena).",
            "## Mareas",
            "La gravedad de la Luna deforma ligeramente los océanos y produce las mareas.",
            "## Cómo observarla",
            "Con binoculares o telescopio, los mejores momentos son los cuartos: la luz rasante en el borde entre día y noche resalta los cráteres y las montañas."),

        new Item("MÓDULO 4", "Estrellas y galaxias",
            "Nacimiento, vida y muerte de las estrellas.",
            "Las estrellas son enormes esferas de gas que brillan gracias a la fusión nuclear en su núcleo. Su vida depende de su masa: cuanto más masiva es una estrella, más rápido consume su combustible.",
            "## Ciclo de vida",
            "• Nacimiento: en nebulosas, nubes de gas y polvo que se contraen por gravedad.",
            "• Vida estable: la secuencia principal. El Sol está aproximadamente a la mitad de ella.",
            "• Final: las estrellas como el Sol terminan como enanas blancas; las muy masivas explotan como supernovas y dejan estrellas de neutrones o agujeros negros.",
            "## Galaxias",
            "Una galaxia es un conjunto de estrellas, gas y polvo unido por la gravedad. Vivimos en la Vía Láctea, una galaxia espiral con cientos de miles de millones de estrellas.",
            "La galaxia de Andrómeda está a unos 2.5 millones de años luz y es visible a simple vista como una tenue mancha en cielos muy oscuros."),

        new Item("MÓDULO 5", "Telescopios y observación",
            "Tipos de telescopio y práctica en el observatorio.",
            "El telescopio es la herramienta principal del astrónomo. Su función no es solo aumentar la imagen, sino sobre todo reunir más luz para ver objetos débiles.",
            "## Tipos de telescopio",
            "• Refractor: usa lentes; es sencillo y muy bueno para la Luna y los planetas.",
            "• Reflector: usa espejos; ofrece mucha apertura a menor costo.",
            "• Catadióptrico: combina lentes y espejos en un tubo compacto.",
            "## Lo que debes saber",
            "• La apertura (el diámetro del lente o espejo) es la característica más importante.",
            "• Una buena montura da estabilidad y facilita seguir los astros.",
            "• Más aumento no siempre significa mejor imagen.",
            "## Buenas prácticas de observación",
            "• Busca un sitio con poca contaminación lumínica.",
            "• Espera unos 20 minutos para que tus ojos se adapten a la oscuridad.",
            "• Usa luz roja para no perder esa adaptación.",
            "## Práctica en el observatorio",
            "Consulta fechas y horarios de las sesiones de observación en el sitio web oficial del observatorio.")
    };

    static final Item[] BOLETIN = {
        new Item("LLUVIA DE METEOROS", "Leónidas: el máximo de noviembre",
            "Alrededor del 17 y 18 de noviembre.",
            "Cada año, a mediados de noviembre, la Tierra atraviesa los restos de polvo que dejó el cometa 55P/Tempel–Tuttle. Al entrar en la atmósfera, esos granitos se encienden y vemos meteoros: las Leónidas.",
            "## Lo esencial",
            "• Máximo: alrededor del 17 y 18 de noviembre (fechas aproximadas).",
            "• Origen aparente: la constelación de Leo, de donde toma su nombre.",
            "• Velocidad: unos 71 km/s, entre las más rápidas del año.",
            "• Actividad típica: unas 10 a 15 meteoros por hora en cielos oscuros.",
            "## Cómo observarlas",
            "Lo mejor es la madrugada, cuando Leo está más alto en el cielo. No necesitas telescopio ni binoculares: recuéstate, mira hacia arriba con amplitud y ten paciencia durante al menos una hora.",
            "Las Leónidas son famosas porque aproximadamente cada 33 años pueden producir tormentas de meteoros, como ocurrió en 1833, 1966 y a inicios de los años 2000. En un año normal la actividad es más modesta, pero sigue siendo una cita agradable.",
            "Nota: las fechas y horas son aproximadas; consulta el sitio del observatorio para actividades."),

        new Item("LLUVIA DE METEOROS", "Gemínidas: la lluvia más generosa",
            "Máximo alrededor del 13 y 14 de diciembre.",
            "Las Gemínidas suelen ser la lluvia de meteoros más abundante del año. Curiosamente, su origen no es un cometa sino un asteroide: 3200 Faetón.",
            "## Lo esencial",
            "• Máximo: alrededor del 13 y 14 de diciembre (fechas aproximadas).",
            "• Origen aparente: cerca de Cástor, en la constelación de Géminis.",
            "• Velocidad: unos 35 km/s, más lenta que las Leónidas; por eso los meteoros se ven brillantes y con colores.",
            "• Actividad típica: hasta unos 100 o más meteoros por hora en cielos muy oscuros.",
            "## Cómo observarlas",
            "A diferencia de otras lluvias, empiezan a verse desde las primeras horas de la noche, y el mejor momento suele ser alrededor de las 2 de la madrugada. Este año la Luna será una delgada creciente que se oculta temprano, un escenario favorable.",
            "Lleva ropa de abrigo, una silla reclinable y una bebida caliente: diciembre es frío.",
            "Nota: las fechas y horas son aproximadas; consulta el sitio del observatorio para actividades."),

        new Item("TEMPORADA", "Solsticio de diciembre",
            "El 21 de diciembre comienza el invierno astronómico.",
            "El solsticio de diciembre marca el inicio del invierno en el hemisferio norte y del verano en el sur. Es la noche más larga del año para quienes vivimos al norte del ecuador.",
            "## ¿Por qué ocurre?",
            "La Tierra tiene su eje inclinado unos 23.4°. En diciembre, el hemisferio norte apunta lejos del Sol y recibe sus rayos más inclinados, por eso los días son más cortos y las noches más largas.",
            "## Un detalle que sorprende",
            "La Tierra está más cerca del Sol a inicios de enero. Las estaciones no dependen de la distancia al Sol, sino de la inclinación del eje.",
            "## Para observar",
            "• Las noches largas son una buena oportunidad para observar con calma.",
            "• La constelación de Orión domina el cielo de invierno; ubica sus Tres Marías y busca la Nebulosa de Orión justo debajo."),

        new Item("GUÍA", "Cómo empezar a observar el cielo",
            "Cinco pasos sencillos para tu primera noche.",
            "No necesitas equipo caro para empezar: con los ojos, un poco de paciencia y buen cielo, ya puedes disfrutar de la astronomía.",
            "## Cinco pasos",
            "• 1. Busca un lugar oscuro, lejos de farolas y construcciones iluminadas.",
            "• 2. Deja que tus ojos se adapten durante 20 minutos y evita mirar el celular; si lo usas, baja el brillo o activa el modo rojo.",
            "• 3. Aprende primero las constelaciones brillantes con una carta celeste o una aplicación de mapas del cielo.",
            "• 4. Antes de comprar un telescopio, prueba con unos binoculares: muestran cráteres de la Luna, cúmulos de estrellas y las lunas de Júpiter.",
            "• 5. Lleva abrigo, anota lo que ves y repite la observación varias noches.",
            "## Consejo del observatorio",
            "Observar con alguien que ya sabe es la forma más rápida de aprender. Visita las actividades del observatorio y pregunta lo que quieras."),

        new Item("DATO ASTRONÓMICO", "Mirar el cielo es mirar al pasado",
            "La luz tarda años en llegar hasta nosotros.",
            "La luz viaja a unos 300,000 kilómetros por segundo, pero el universo es tan grande que esa velocidad no basta para que llegue al instante. Por eso, lo que vemos en el cielo es siempre una imagen del pasado.",
            "## El año luz",
            "Un año luz es la distancia que recorre la luz en un año: unos 9.5 billones de kilómetros.",
            "## Ejemplos",
            "• La Luna: la vemos como era hace poco más de un segundo.",
            "• El Sol: lo vemos como era hace unos 8 minutos.",
            "• Sirio, la estrella más brillante de la noche: está a unos 8.6 años luz.",
            "• La Nebulosa de Orión: la luz que ves salió hace unos 1,300 años.",
            "• La galaxia de Andrómeda: su luz tardó unos 2.5 millones de años en llegar.",
            "Así, un telescopio es también una máquina del tiempo: cuanto más lejos miramos, más atrás en la historia del universo estamos viendo.")
    };
}
