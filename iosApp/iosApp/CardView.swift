//
//  CardView.swift
//  Scrumdinger
//
//  Created by Tomislav Strelar on 10.12.2023..
//

import SwiftUI
import shared

struct CardView: View {
    let scrum: DailyScrum
    var body: some View {
        VStack(alignment: .leading) {
            Text(scrum.title)
                .font(.headline)
                .accessibilityAddTraits(.isHeader)
            Spacer()
            HStack {
                Label("\(scrum.attendees.count)", systemImage: "person.3")
                    .accessibilityLabel("\(scrum.attendees.count) attendees")
                Spacer()
                Label("\(scrum.lengthInMinutes)", systemImage: "clock")
                    .accessibilityLabel("\(scrum.lengthInMinutes) minute meeting")
                    .labelStyle(.trailingIcon)
            }
            .font(.caption)
        }
        .padding()
        .foregroundColor(scrum.theme.accentColor())
    }
}

struct CardView_Previews: PreviewProvider {
    static var scrum = DailyScrum(
        title: "Test",
        attendees: [],
        lengthInMinutes: 10,
        theme: Theme.bubblegum
    )
    static var previews: some View {
        CardView(scrum: scrum)
            .background(Color("yellow"))
            .previewLayout(.fixed(width: 400, height: 60))
    }
}
