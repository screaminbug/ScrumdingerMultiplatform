//
//  Theme.swift
//  Scrumdinger
//
//  Created by Tomislav Strelar on 10.12.2023..
//

import SwiftUI
import shared

extension Theme {
    
    func accentColor() -> Color {
        switch self {
        case .bubblegum, .buttercup, .lavender, .orange, .periwinkle, .poppy, .seafoam, .sky, .tan, .teal, .yellow: return Color.black
        case .indigo, .magenta, .navy, .oxblood, .purple: return Color.white
        default:
            return Color.white
        }
    }
    
    func mainColor() -> Color {
        Color(self.name)
    }
}
